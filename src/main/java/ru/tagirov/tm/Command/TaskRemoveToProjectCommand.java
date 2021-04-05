package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;
import java.util.Map;

public class TaskRemoveToProjectCommand extends AbstractCommand {

    public TaskRemoveToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-remove-to-project";
    }

    @Override
    public String getDescripion() {
        return "delete a task in the project.";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[TASK REMOVE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER TASK NAME:");
        nameTask = reader.readLine();
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)){
                for(int i = 0; i < tmp.getValue().taskListToProject.size(); i++){
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)){
                        tmp.getValue().taskListToProject.remove(i);
                    }
                }
            }

        }
        System.out.println("[OK]");
        System.out.println();
    }
}
