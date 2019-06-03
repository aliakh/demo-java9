package demo.core_libraries.reactive_streams;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class ReactiveStreamsTest {

    @Test
    public void givenPublisher_whenSubscribeToIt_thenShouldConsumeAllElements() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        DemoSubscriber<String> subscriber = new DemoSubscriber<>(6);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        //when
        assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        //then
        await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(items)
        );
    }

    @Test
    public void givenPublisher_whenSubscribeAndTransformElements_thenShouldConsumeAllElements() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        DemoProcessor<String, Integer> transformProcessor = new DemoProcessor<>(Integer::parseInt);
        DemoSubscriber<Integer> subscriber = new DemoSubscriber<>(3);
        List<String> items = List.of("1", "2", "3");
        List<Integer> expectedResult = List.of(1, 2, 3);

        //when
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);
        items.forEach(publisher::submit);
        publisher.close();

        //then
        await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(expectedResult)
        );
    }

    @Test
    public void givenPublisher_whenRequestForOnlyOneElement_thenShouldConsumeOnlyThatOne() throws InterruptedException {
        //given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        DemoSubscriber<String> subscriber = new DemoSubscriber<>(1);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        List<String> expected = List.of("1");

        //when
        assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        //then
        await().atMost(1000, TimeUnit.MILLISECONDS).until(
                () -> assertThat(subscriber.consumedElements).containsExactlyElementsOf(expected)
        );
    }
}