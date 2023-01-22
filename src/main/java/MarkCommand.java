/**
 * Represents Duke's mark function.
 */
public class MarkCommand extends Command {
    public MarkCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeException {
        Integer taskNum = ui.getTaskNum();
        String s = tasks.mark(taskNum);
        ui.printWithPartition("\tNice! I've marked this task as done:\n\t  " + s + "\n");

    };

}
