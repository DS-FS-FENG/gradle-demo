package com.mahosyojyo.project_structure_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by FredFung on 2014/6/1.
 */

/**
 *  TODO
 *  自定义plugin
 *  实现apply时的动作
 *  */
class ProjectStructurePlugin implements Plugin<Project> {

    def javaPath = '/src/main/java/com/mahosyojyo/'
    def resourcePath = '/src/main/resources/'

    def projectStructurePathes = [
            javaPath + 'bean',
            javaPath + 'dao',
            javaPath + 'service',
            javaPath + 'controller',
            resourcePath + 'META-INF',
            resourcePath + 'spring',
            resourcePath + 'properties'
    ] as String[]

    @Override
    void apply(Project project) {
        project.logger.info("Configuring Project Structure for $project.name")

        addTask(project)
    }

    private void addTask(Project project) {
        //通过自定义task添加task
        project.getTasks().create("createSrc", CreateSourceDirsTask.class);


        //直接添加task
        project.getTasks().create("createSpringStructure") << {
            String projectDir = project.projectDir.getPath();

            projectStructurePathes.each {
                dir = new File(projectDir + it)
                dir.mkdirs()
            }
        }
    }
}
