package interview.twilio;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Result {

    public static final String JSON_URL = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
        List<Integer> result = new ArrayList<>();
        if (txnType != null && monthYear != null) {
            List<User> data = getJSONFromUrl(uid);
            filterData(result, txnType, monthYear, data);
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    private static void filterData(List<Integer> result, String txnType, String monthYear, List<User> userData) {
        List<User> filteredUserData = userData.stream()
                .filter(user -> filterDate(user.timestamp, monthYear))
                .filter(user -> user.txnType.equalsIgnoreCase(txnType)).collect(Collectors.toList());
        getAverageForMonthYear(txnType, filteredUserData, monthYear).ifPresent(averageAmount -> {
            filteredUserData
                    .stream()
                    .filter(user -> compareAmount(averageAmount, user))
                    .forEach(user -> result.add(user.id));
        });


    }

    private static boolean compareAmount(double averageAmount, User user) {
        double amount = convertDouble(user.amount);
        return Double.compare(amount, averageAmount) >= 0;
    }

    private static OptionalDouble getAverageForMonthYear(String txnType, List<User> userData, String monthYear) {
        return userData.stream()
                .filter(user -> user.txnType.equalsIgnoreCase(txnType))
                .filter(user -> filterDate(user.timestamp, monthYear))
                .mapToDouble(v -> convertDouble(v.amount))
                .average();
    }

    private static double convertDouble(String amount) {
        amount = amount.replaceAll("\\$", "");
        amount = amount.replaceAll(",", "");
        return Double.parseDouble(amount);
    }

    private static boolean filterDate(String timestamp, String monthYear) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
            String convertedDate = dateFormat.format(new Date(Long.parseLong(timestamp)));

            return convertedDate.contains(monthYear);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static List<User> getJSONFromUrl(int uid) {
        List<User> users = new ArrayList<>();
        ApiResponse apiResponse;
        URL url = null;
        int totalPages = 0;
        int currentPage = 1;
        do {
            try {
                url = new URL(JSON_URL + uid + "&page=" + currentPage);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                apiResponse = new Gson().fromJson(reader, ApiResponse.class);
                totalPages = apiResponse.total_pages;
                currentPage++;
                users.addAll(apiResponse.data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (currentPage < totalPages);
        return users;
    }


}

class ApiResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<User> data;

}

class User {
    public int id;
    public int userId;
    public String userName;
    public String timestamp;
    public String txnType;
    public String amount;
    public Location LocationObject;
    public String ip;
}

class Location {
    public int id;
    public String address;
    public String city;
    public int zipCode;

}

public class RestApiParser {
    public static void main(String[] args) throws IOException {

        List<Integer> result = Result.getUserTransaction(4, "debit", "02-2019");
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}

