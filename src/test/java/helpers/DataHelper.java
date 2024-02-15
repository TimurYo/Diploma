package helpers;

import lombok.NoArgsConstructor;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
public class DataHelper {

    @Value
    public static class CardInformationModel {
        String number;
        String month;
        String year;
        String name;
        String cvc;

        public static String approvedCardNumber = "4444 4444 4444 4441";
        public static String declinedCardNumber = "4444 4444 4444 4442";
        public static String symbols = ";%?%№;;№;%:?";

        public static CardInformationModel getValidFormApprovedCard() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getValidFormDeclinedCard() {

            return new CardInformationModel(declinedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getEmptyForm() {
            return new CardInformationModel("", "", "", "", "");
        }

        // Number
        public static CardInformationModel getFormWithSingleNumber() {

            return new CardInformationModel(DataGenerator.generateSingleNumber(), DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getFormWithSixteenNulls() {

            return new CardInformationModel("0000000000000000", DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getFormWithFourteenNumber() {

            return new CardInformationModel(DataGenerator.generateFourteenNumber(), DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getFormWithLettersIntoNumberField() {

            return new CardInformationModel(DataGenerator.generateLetters(), DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getFormWithSymbols() {

            return new CardInformationModel(symbols, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        // Month
        public static CardInformationModel getMonthWithNulls() {

            return new CardInformationModel(approvedCardNumber, "00",
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getMonthWithSingleNumber() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateSingleNumber(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getMonthWithLetters() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateLetters(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getMonthWithSymbols() {

            return new CardInformationModel(approvedCardNumber, symbols,
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getMonthWithInvalidNumber() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateInvalidNumberForMonthField(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getInvalidMonthMinus() {
            String dateNow = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
            String year = null;
            String month = null;

            if (dateNow != "01") {
                month = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
                year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
            } else {
                month = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
                year = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yy"));
            }
            return new CardInformationModel(approvedCardNumber, month,
                    year, DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }
        public static CardInformationModel getValidMonthPlus() {
            String dateNow = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
            String yearPlus = null;
            String monthPlus = null;
            if (dateNow != "12") {
                monthPlus = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
                yearPlus = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("YY"));
            } else {
                monthPlus = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
                yearPlus = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
            }
            return new CardInformationModel(approvedCardNumber, monthPlus,
                    yearPlus, DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        // Year
        public static CardInformationModel getYearWithNulls() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    "00", DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getYearWithSingleNumber() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateSingleNumber(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getYearWithLetters() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateLetters(), DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getYearWithSymbols() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    symbols, DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getInvalidYearMoreFiveYearsLater() {
            int years = 6;
            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYearPlusYears(years)
                    , DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getInvalidYearWithMoreSixtyMonths() {
            int shift = 61;
            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonthPlus(shift),
                    DataGenerator.generateYearPlus(shift)
                    , DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getInvalidYearWithMinusFiveYears() {
            int negativeShift = 60;
            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYearWithMinus(negativeShift)
                    , DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getInvalidYearWithMinusOneYear() {
            int negativeYears = 1;
            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYearMinusYears(negativeYears)
                    , DataGenerator.generateValidName(), DataGenerator.generateTripleNumber());
        }

        //Name
        public static CardInformationModel getNameWithBothify() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateBothify(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getNameWithLettersAndSymbols() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName() + symbols, DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getNameWithSymbols() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), symbols, DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getJapaneseName() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateJapaneseName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getRussianName() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateRuName(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getNameWithSingleLetter() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateSingleLetter(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getNameWith254Letters() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateManyLetters(), DataGenerator.generateTripleNumber());
        }

        public static CardInformationModel getNameWithNumbers() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), declinedCardNumber, DataGenerator.generateTripleNumber());
        }

        //CVC
        public static CardInformationModel getCvcWithSingleNumber() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateSingleNumber());
        }

        public static CardInformationModel getCvcWithDoubleNumber() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateDoubleNumber());
        }

        public static CardInformationModel getCvcWithTripleNull() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), "000");
        }

        public static CardInformationModel getCvcWithLetters() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), DataGenerator.generateLetters());
        }

        public static CardInformationModel getCvcWithSymbols() {

            return new CardInformationModel(approvedCardNumber, DataGenerator.generateMonth(),
                    DataGenerator.generateYear(), DataGenerator.generateValidName(), symbols);
        }
    }
}
