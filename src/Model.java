import javax.swing.*;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Model {

    private String periodOfLearn;

    private String nowDays;

    public String getPeriodOfLearn() {
        return periodOfLearn;
    }

    public String getNowDays() {
        return nowDays;
    }

    public static void main(String[] args) {
        Model main = new Model();
        main.setPeriodOfLearn(main.countPeriodOfLearn());
        main.setNowDays();
        Controller controller = new Controller(main);
        View view = new View("JavaLearn", controller);
        
        SwingUtilities.invokeLater(() -> view.initView());
    }

    public void setPeriodOfLearn(String periodOfLearn) {
        this.periodOfLearn = periodOfLearn;
    }

    public String countPeriodOfLearn() {
        LocalDate dateStart = LocalDate.of(2022, 5, 6);
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateStart, now);

        int countOfMonth = period.getMonths();
        int countOfDays = period.getDays();

        MessageFormat messageFormat = new MessageFormat("Вы занимаетесь Java {0} и {1}");
        Object[] argsMessage = {countOfMonth, countOfDays};

        double[] limitsMonths = {0, 1, 2, 5};
        String[] filePartMonth = {"{0} месяцев", "{0} месяц", "{0} месяца", "{0} месяцев"};
        ChoiceFormat formatMonths = new ChoiceFormat(limitsMonths, filePartMonth);

        double[] limitsDays = {0, 1, 2, 5, 21, 22, 25};
        String[] filePartDays = {"{1} дней", "{1} день", "{1} дня", "{1} дней", "{1} день", "{1} дня", "{1} дней"};
        ChoiceFormat formatDays = new ChoiceFormat(limitsDays, filePartDays);

        Format[] formats = {formatMonths, formatDays};
        messageFormat.setFormats(formats);

        return messageFormat.format(argsMessage) + ".";
    }

    public void setNowDays() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy  H:mm");
        nowDays = dateTimeFormatter.format(LocalDateTime.now());

    }
}