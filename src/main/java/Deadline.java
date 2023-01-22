import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The Deadline class extends the DatedTask class and represents a datedtask with a due date.
 */
public class Deadline extends DatedTask {
    private static final long serialVersionUID = 102;

    private LocalDate date;

    /**
     * Constructs a Deadline Task with a due date.
     *
     * @param name The name of the task.
     * @param date The date of when the task is due.
     */
    public Deadline(String name, String date) throws DukeException {
        super(name, date);
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new DukeException(
                    "The deadline command should be used like this:\n" + "\tdeadline {name} /by {date}");
        }

    }

    /**
     * Returns the string representation of the deadline.
     *
     * @return The string representation of the deadline.
     */
    @Override
    public String toString() {
        DateTimeFormatter daydmy = DateTimeFormatter.ofPattern("E, d MMM uu");
        return "[D]" + super.toString() + " (by: " + this.date.format(daydmy) + ")";
    }

}
