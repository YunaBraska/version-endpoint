[var target]: # (/)

# !{project.name}
*Creates a version endpoint with git properties like SHA etc.*

[include]: # (/README/shields.include.md)

### How to use it
```xml
<dependency>
    <groupId>!{project.groupId}</groupId>
    <artifactId>!{project.artifactId}</artifactId>
    <version>!{project.version}</version>
</dependency>
```

### Configuration
```yaml
management:
  endpoint:
    version:
      path: /internal/version
```

```json
{
    "projectName": "!{project.artifactId}",
    "projectGroup": "!{project.groupId}",
    "projectArtifact": "!{project.artifactId}",
    "projectVersion": "!{project.version}",
    "git": {
        "tags": "",
        "build.version": "!{project.version}",
        "closest.tag.commit.count": "20",
        "commit.user.name": "Yuna Morgenstern",
        "commit.id.abbrev": "a6729de",
        "branch": "testbranch",
        "build.host": "Cr15t4lF1r3",
        "commit.id.describe-short": "0.1.0-1-dirty",
        "total.commit.count": "8",
        "commit.id.describe": "0.1.0-1-ga6729de-dirty",
        "build.user.email": "git@example.com",
        "commit.id": "a6729de1f723aa3ddc84635a7cf9769dea489e17",
        "commit.message.short": "my cool commit message",
        "commit.user.email": "git@example.com",
        "closest.tag.name": "!{project.version}",
        "local.branch.ahead": "0",
        "build.time": "1988-08-20T20:12:58+0100",
        "commit.time": "1988-08-20T18:22:17+0100",
        "local.branch.behind": "0",
        "build.user.name": "",
        "dirty": "true",
        "commit.message.full": "my cool commit message",
        "remote.origin.url": "https://github.com/YunaBraska/version-endpoint.git"
    }
}
```

### Troubleshooting
* BuildProperties are not initialized: just the following command 
```shell script
mvn clean compile
```

* Add spring-boot-maven-plugin if the solution above did't help 
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>${spring-boot.version}</version>
    <executions>
        <execution>
            <phase>compile</phase>
            <id>build-info</id>
            <goals>
                <goal>build-info</goal>
            </goals>
        </execution>
    </executions>
</plugin>                
```

### TODO
[ ] path to custom properties file

![logo](logo.png "logo")