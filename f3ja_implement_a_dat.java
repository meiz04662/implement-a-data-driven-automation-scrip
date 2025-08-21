import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptTracker {

    // Data-driven script configuration
    private Map<String, ScriptConfig> scriptConfigs;
    private List<ScriptExecution> scriptExecutions;

    public ScriptTracker() {
        scriptConfigs = new HashMap<>();
        scriptExecutions = new ArrayList<>();
    }

    public void addScriptConfig(String scriptName, String scriptType, String scriptCommand) {
        ScriptConfig scriptConfig = new ScriptConfig(scriptName, scriptType, scriptCommand);
        scriptConfigs.put(scriptName, scriptConfig);
    }

    public void executeScript(String scriptName) {
        ScriptConfig scriptConfig = scriptConfigs.get(scriptName);
        if (scriptConfig != null) {
            ScriptExecution scriptExecution = new ScriptExecution(scriptConfig);
            scriptExecutions.add(scriptExecution);
            scriptExecution.execute();
        }
    }

    public List<ScriptExecution> getScriptExecutions() {
        return scriptExecutions;
    }

    private class ScriptConfig {
        private String scriptName;
        private String scriptType;
        private String scriptCommand;

        public ScriptConfig(String scriptName, String scriptType, String scriptCommand) {
            this.scriptName = scriptName;
            this.scriptType = scriptType;
            this.scriptCommand = scriptCommand;
        }

        public String getScriptName() {
            return scriptName;
        }

        public String getScriptType() {
            return scriptType;
        }

        public String getScriptCommand() {
            return scriptCommand;
        }
    }

    private class ScriptExecution {
        private ScriptConfig scriptConfig;
        private String executionStatus;
        private String executionOutput;

        public ScriptExecution(ScriptConfig scriptConfig) {
            this.scriptConfig = scriptConfig;
        }

        public void execute() {
            // TO DO: implement script execution logic
            // For demonstration purposes, just set the execution status and output
            executionStatus = "Success";
            executionOutput = "Script executed successfully";
        }

        public String getExecutionStatus() {
            return executionStatus;
        }

        public String getExecutionOutput() {
            return executionOutput;
        }
    }

    public static void main(String[] args) {
        ScriptTracker scriptTracker = new ScriptTracker();

        scriptTracker.addScriptConfig("Script1", " Shell", "echo 'Hello World!' ");
        scriptTracker.addScriptConfig("Script2", "Python", "python -c 'print(\"Hello World!\")'");

        scriptTracker.executeScript("Script1");
        scriptTracker.executeScript("Script2");

        List<ScriptExecution> scriptExecutions = scriptTracker.getScriptExecutions();
        for (ScriptExecution scriptExecution : scriptExecutions) {
            System.out.println("Script Name: " + scriptExecution.scriptConfig.getScriptName());
            System.out.println("Script Type: " + scriptExecution.scriptConfig.getScriptType());
            System.out.println("Script Command: " + scriptExecution.scriptConfig.getScriptCommand());
            System.out.println("Execution Status: " + scriptExecution.getExecutionStatus());
            System.out.println("Execution Output: " + scriptExecution.getExecutionOutput());
            System.out.println();
        }
    }
}