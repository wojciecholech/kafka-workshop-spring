package com.sinch.kafka1;

import com.sinch.kafka1.infrastructure.SimpleLogConsumer;
import com.sinch.kafka1.infrastructure.SimpleLogConsumer.AnsiColor;
import java.io.File;
import lombok.SneakyThrows;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

public class BlackBoxTestEnvironment {

  public static final String SERVICE = "app-service";
  public static final int SERVICE_PORT = 8080;


  private static DockerComposeContainer container;

  public static void start() {
    if (container == null) {
      container =
          new DockerComposeContainer(composeFile())
              .withRemoveImages(DockerComposeContainer.RemoveImages.LOCAL)
              .withExposedService(SERVICE, SERVICE_PORT, Wait.forListeningPort())
              .withLogConsumer(SERVICE, new SimpleLogConsumer(SERVICE, AnsiColor.RED));

      container.start();
    }
  }

  @SneakyThrows
  private static File composeFile() {
    return new File("./docker-compose.yml");
  }

  public static String serviceHost() {
    return container.getServiceHost(SERVICE, SERVICE_PORT);
  }

  public static Integer servicePort() {
    return container.getServicePort(SERVICE, SERVICE_PORT);
  }

  public static String serviceUrl() {
    var host = container.getServiceHost(SERVICE, SERVICE_PORT);
    var port = container.getServicePort(SERVICE, SERVICE_PORT);

    return String.format("http://%s:%d", host, port);
  }
}
