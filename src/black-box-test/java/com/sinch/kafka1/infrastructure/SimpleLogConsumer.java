package com.sinch.kafka1.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.output.BaseConsumer;
import org.testcontainers.containers.output.OutputFrame;

@Slf4j
public class SimpleLogConsumer extends BaseConsumer<SimpleLogConsumer> {

  private final String prefix;

  public SimpleLogConsumer(String prefix, AnsiColor color) {
    this.prefix = color.value + prefix + AnsiColor.RESET.value;
  }

  @Override
  public void accept(OutputFrame outputFrame) {
    System.out.print(prefix + ": " + outputFrame.getUtf8String());
  }

  @RequiredArgsConstructor
  public enum AnsiColor {
    RESET("\u001B[0m"),
    WHITE("\u001B[37m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m");

    public final String value;
  }
}
