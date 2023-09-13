package Fabio.ReisChallenge.week.XII.msrace.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RabbitMQConfigTest {


    private RabbitMQConfig rabbitMQConfig;

    @BeforeEach
    void setUp() {
        rabbitMQConfig = new RabbitMQConfig();
    }

    @Test
    void testDirectExchange() {
        DirectExchange directExchange = rabbitMQConfig.directExchange();
        assertNotNull(directExchange);
        assertEquals(RabbitMQConfig.EXCHANGE_NAME, directExchange.getName());
    }

    @Test
    void testQueue() {
        Queue queue = rabbitMQConfig.queue();
        assertNotNull(queue);
        assertEquals(RabbitMQConfig.QUEUE_NAME, queue.getName());
    }

}