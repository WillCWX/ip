/**
 * Represents Duke's Echo function.
 */
public class EchoCommand extends Command {
    public EchoCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) {
        ui.printNextInput();
    };

}
