package datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.Month.FEBRUARY;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TemporalAdjustersTest {

    private LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.of(2017, FEBRUARY, 7);
    }

    @Test
    public void shouldReturnFirstDayOfMonth() throws Exception {
        assertThat(date.with(firstDayOfMonth())).isEqualTo("2017-02-01");
    }

    @Test
    public void shouldReturnFirstDayOfNextMonth() throws Exception {
        assertThat(date.with(firstDayOfNextMonth())).isEqualTo("2017-03-01");
    }

    @Test
    public void shouldReturnFirstDayOfYear() throws Exception {
        assertThat(date.with(firstDayOfYear())).isEqualTo("2017-01-01");
    }

    @Test
    public void shouldReturnFirstDayOfNextYear() throws Exception {
        assertThat(date.with(firstDayOfNextYear())).isEqualTo("2018-01-01");
    }

    @Test
    public void shouldReturnFirstMondayInMonth() throws Exception {
        assertThat(date.with(firstInMonth(MONDAY))).isEqualTo("2017-02-06");
    }

    @Test
    public void shouldReturnNextTuesday() throws Exception {
        assertThat(date.with(next(TUESDAY))).isEqualTo("2017-02-14");
    }

    @Test
    public void shouldReturnNextOrSameTuesday() throws Exception {
        assertThat(date.with(nextOrSame(TUESDAY))).isEqualTo("2017-02-07");
    }

    @Test
    public void shouldReturnPreviousTuesday() throws Exception {
        assertThat(date.with(previous(TUESDAY))).isEqualTo("2017-01-31");
    }

    @Test
    public void shouldReturnPreviousOrSameTuesday() throws Exception {
        assertThat(date.with(previousOrSame(TUESDAY))).isEqualTo("2017-02-07");
    }

    @Test
    public void shouldReturnLastDayOfMonth() throws Exception {
        assertThat(date.with(lastDayOfMonth())).isEqualTo("2017-02-28");
    }

    @Test
    public void shouldReturnLastDayOfYear() throws Exception {
        assertThat(date.with(lastDayOfYear())).isEqualTo("2017-12-31");
    }

    @Test
    public void shouldReturnLastDayTuesdayInMonth() throws Exception {
        assertThat(date.with(lastInMonth(TUESDAY))).isEqualTo("2017-02-28");
    }

    @Test
    public void shouldReturnSecondTuesdayInMonth() throws Exception {
        assertThat(date.with(dayOfWeekInMonth(2, TUESDAY))).isEqualTo("2017-02-14");
    }

    @Test
    public void shouldReturnSecondLastTuesdayInMonth() throws Exception {
        assertThat(date.with(dayOfWeekInMonth(-2, TUESDAY))).isEqualTo("2017-02-21");
    }

    @Test
    public void shouldReturnLastMonthsLastTuesday() throws Exception {
        assertThat(date.with(dayOfWeekInMonth(0, TUESDAY))).isEqualTo("2017-01-31");
    }

    @Test
    public void shouldAddThreeDays() throws Exception {
        assertThat(date.with(ofDateAdjuster(localDate -> localDate.plus(3, DAYS)))).isEqualTo("2017-02-10");
    }
}
