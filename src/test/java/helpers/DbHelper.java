package helpers;

import objects.CreditTableObject;
import objects.OrderTableObject;
import objects.PaymentTableObject;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbHelper {
    private static QueryRunner runner = new QueryRunner();
    private static Connection conn;
    private static String dbUrl = System.getProperty("dbUrl");

    private DbHelper() {
    }

    private static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, "app", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void cleanDB()  {
        var creditRequest = "DELETE FROM credit_request_entity";
        var order = "DELETE FROM order_entity";
        var payment = "DELETE FROM payment_entity";
        try (var conn = getConnection()) {
            runner.update(conn, creditRequest);
            runner.update(conn, order);
            runner.update(conn, payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static PaymentTableObject getPaymentEntity() {
        var sqlRequest = "SELECT * FROM payment_entity";
        try (var conn = getConnection()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(PaymentTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static OrderTableObject getOrderEntity() {
        var sqlRequest = "SELECT * FROM order_entity";
        try (var conn = getConnection()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(OrderTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static CreditTableObject getCreditEntity() {
        var sqlRequest = "SELECT * FROM credit_request_entity";
        try (var conn = getConnection()) {
            var requestResult = runner.query(conn, sqlRequest, new BeanHandler<>(CreditTableObject.class));
            return requestResult;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    // Helpers for time tests
    public static Date getDbTimeInDateFormatPaymentEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getPaymentEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForPaymentEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatPaymentEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatCreditEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getCreditEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForCreditEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatCreditEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatOrderEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getOrderEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForOrderEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatOrderEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }
}
