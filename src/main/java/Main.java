public class Main {
    public static void main(String[] args) {
        NewFile file = new NewFile(true);
        file.openWriter();
        file.writeTo("Print('Hullo, world')");
        file.closeWriter();
        ShellCommand command = new ShellCommand();
        command.addCommand("cd ..");
        command.addCommand("dir");
        command.execute();
    }
}