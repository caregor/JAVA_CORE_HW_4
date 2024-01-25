package ru.gb.hw;

import ru.gb.hw.exceptions.CustomerNotExistException;
import ru.gb.hw.exceptions.ProductNotExistException;
import ru.gb.hw.exceptions.QuantityException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws CustomerNotExistException, ProductNotExistException, QuantityException {
        System.out.println("online shop");
        Customer[] customers = {
                new Customer("Ivanov Ivan", LocalDate.of(1987, 12, 9), "+9867566473", Gender.MALE),
                new Customer("Petrov Petr", LocalDate.of(1988, 12, 20), "+9867566475", Gender.MALE),
                new Customer("Masha Petrova", LocalDate.of(1989, 11, 1), "+9867566476", Gender.FEMALE)
        };

        OnlineShop.getCustomerList().add(customers[0]);
        OnlineShop.getCustomerList().add(customers[1]);
        OnlineShop.getProductList().add(new Product("apple", BigDecimal.valueOf(10L)));
        OnlineShop.getProductList().add(new Product("pineapple", BigDecimal.valueOf(50L)));


        try {
            Order order = null;
            order = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");


            OnlineShop.getOrderList().add(order);
            //System.out.println(OnlineShop.getOrderList());

            Order order2 = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");
            OnlineShop.getOrderList().add(order2);
           // System.out.println(OnlineShop.getOrderList());

            Order order3 = OnlineShop.buyProduct("Petrov Petr", "pineapple", "300");
            OnlineShop.getOrderList().add(order3);


        } catch (QuantityException e) {
            OnlineShop.getOrderList().add(OnlineShop.buyProduct(e.getCustomer(), e.getProduct(), "1"));
        } catch (ProductNotExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw e;
        }

        //System.out.println(OnlineShop.getOrderList());
        System.out.println(OnlineShop.getOrderList().size() + " orders received");

        LocalDate today = LocalDate.parse("2024-02-23");

        congratulate(customers, today);

    }
    /**
     * Поздравляет покупателей в зависимости от текущего праздника.
     *
     * @param customers Массив покупателей.
     */
    private static void congratulate(Customer[] customers, LocalDate today) {
        Holiday currentHoliday = getHoliday(today);

        for (Customer customer : customers) {
            switch (currentHoliday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + customer.getFIO() + "!");
                    break;
                case INTERNATIONAL_WOMENS_DAY:
                    if (customer.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 Марта, " + customer.getFIO() + "!");
                    }
                    break;
                case DEFENDER_OF_THE_FATHERLAND_DAY:
                    if (customer.getGender() == Gender.MALE) {
                        System.out.println("С 23 Февраля, " + customer.getFIO() + "!");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Определяет текущий праздник по дате.
     *
     * @param date Дата.
     * @return Праздник (Enum Holiday).
     */
    private static Holiday getHoliday(LocalDate date) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();

        if (month == 1 && day == 1) {
            return Holiday.NEW_YEAR;
        } else if (month == 3 && day == 8) {
            return Holiday.INTERNATIONAL_WOMENS_DAY;
        } else if (month == 2 && day == 23) {
            return Holiday.DEFENDER_OF_THE_FATHERLAND_DAY;
        } else {
            return Holiday.NONE;
        }
    }

}