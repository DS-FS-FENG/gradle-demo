package com.mahosyojyo.project_structure_plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskAction

/**
 * Created by FredFung on 2014/6/1.
 * Description:
 * Create Directory: /src/main/java  /src/main/resources  /src/test/java  /src/test/resources
 */

/**
 * TODO
 * 自定义task
 * */
class CreateSourceDirsTask extends DefaultTask {
    def mainPath = "/src/main"
    def testPath = "/src/test"

    def paths = [
            mainPath + "/java",
            mainPath + "/resources",
            testPath + "/java",
            testPath + "/resources"
    ] as String[]


    @TaskAction
    def createSourceDirs() {
        String projectDir = project.projectDir.getPath()
        paths.each {
            dir = new File(projectDir + it)
            dir.mkdirs()
        }
    }
}
