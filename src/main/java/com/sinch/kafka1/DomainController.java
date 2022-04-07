package com.sinch.kafka1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DomainController {

  @GetMapping("/publish/{partition}")
  public void publish(@PathVariable Integer partition) {
    log.info("Publishing event to partition: {}", partition);

  }

  @GetMapping("/batch")
  public void publishBatch() {
    for (int i = 0; i < 1000; i++) {
      log.info("Publishing event: " + i);
    }
  }
}
