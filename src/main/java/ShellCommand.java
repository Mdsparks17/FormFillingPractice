import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellCommand {
    String command = null;

    public boolean addCommand(String nextCommand) {
        if (command == null) {
            command = nextCommand;
        } else {
            command = command + " && " + nextCommand;
        }
        return true;
    }

    public boolean execute() {
        System.out.println("cmd: " + command);
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", command);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
