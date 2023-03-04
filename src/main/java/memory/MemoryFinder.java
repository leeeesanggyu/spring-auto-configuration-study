package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryFinder {

    @PostConstruct
    public void init() {
        log.info("init MemoryFinder");
    }

    public Memory get() {
        // Runtime.getRuntime() JVM 에서 메모리 정보를 실시간으로 조회
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        long used = total - free;
        return new Memory(used, max);
    }
}
