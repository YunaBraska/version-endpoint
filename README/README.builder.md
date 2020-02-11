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

![logo](logo.png "logo")