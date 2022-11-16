import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class TestTask implements IDateSorter {

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> withoutR =
                new ArrayList<>(unsortedDates.stream()
                        .filter(d -> !d.getMonth().name().contains("R"))
                        .sorted(Comparator.reverseOrder()).toList());

        List<LocalDate> withR =
                unsortedDates.stream()
                        .filter(d -> d.getMonth().name().contains("R"))
                        .sorted(Comparator.naturalOrder()).toList();

        return Stream.concat(withR.stream(), withoutR.stream()).toList();

    }

    public static void main(String[] args) throws Exception {
        TestTask testTask = new TestTask();
        List<LocalDate> unsortedDates =
                List.of(
                        LocalDate.parse("2005-07-01"),
                        LocalDate.parse("2005-01-02"),
                        LocalDate.parse("2005-01-01"),
                        LocalDate.parse("2005-05-03")
                );

        System.out.println(testTask.sortDates(unsortedDates));
    }


}