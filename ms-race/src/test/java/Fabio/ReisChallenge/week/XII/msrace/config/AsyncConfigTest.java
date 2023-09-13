package Fabio.ReisChallenge.week.XII.msrace.config;


import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.junit.jupiter.api.Test;


class AsyncConfigTest {

    @Test
    void testThreadPoolConfig() {
        AsyncConfig asyncConfig = new AsyncConfig();
        TaskExecutor taskExecutor = asyncConfig.taskExecutor();

        // Check core pool size
        assert ((ThreadPoolTaskExecutor) taskExecutor).getCorePoolSize() == 2;

        // Check max pool size
        assert ((ThreadPoolTaskExecutor) taskExecutor).getMaxPoolSize() == 4;

        // Check queue capacity
        assert ((ThreadPoolTaskExecutor) taskExecutor).getQueueCapacity() == 10;
    }
}