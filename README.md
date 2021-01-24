Steps
-----

1. In the <build> section 
        add <finalName>${project.artifactId}-${project.version}-${git.commit.id.describe-short}</finalName>
2. Add "git-commit-id-plugin" plugin with necessary configurations as in the pom.xml.
3. To build: mvn clean install
4. Check the jar file name in target folder. It will have the git commit id in the file name.
5. If the artifacts are not committed in git, the file name will be appended with "-dirty.jar"
6. More details about the commit can be found in "git.properties" at <root>/target/classes folder
7. To expose this information at actuator endpoint, refer
    https://rieckpil.de/howto-expose-git-information-with-spring-boots-actuator/
8. Access info endpoint in actuator at http://localhost:8080/actuator/info once started
