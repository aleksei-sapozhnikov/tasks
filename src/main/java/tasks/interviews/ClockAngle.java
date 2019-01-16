package tasks.interviews;

/**
 * Задача: написать программу, которая по заданному времени
 * (часы:минуты) будет определять угол между часовой и минутной стрелками.
 * <p>
 * Откуда: смотрел открытое собеседование на youtube, там
 * интервьювер задал эту задачку.
 *
 * @author Aleksei Sapozhnikov (vermucht@gmail.com)
 * @version 0.1
 * @since 0.1
 */
public class ClockAngle {
    /**
     * Верим, что значения будут заданы адекватные:
     * - час: от 0 до 11
     * - минута: от 0 до 59.
     * <p>
     * Решение:
     * <p>
     * Один час - это 30 градусов часовой стрелки
     * (360 / 12).
     * <p>
     * Одна минута - это 6 градусов
     * минутной стрелки (360/60).
     * <p>
     * Однако, каждую минуту двигается и часовая стрелка.
     * Поэтому одна минута - это еще и 0.5 градуса
     * часовой стрелки (30 / 60).
     * <p>
     * Угол минутной стрелки: минуты * градус одной минуты.
     * Угол часовой стрелки: часы * градус одного часа
     * плюс минуты * градус одной минуты для часовой стрелки.
     *
     * @param hour   Час.
     * @param minute Минута.
     */
    public double angle(int hour, int minute) {
        int angleOneMinute = 360 / 60;
        int angleOneHour = 360 / 12;
        double hourAngleForOneMinute = (double) angleOneHour / 60;
        double hourArrow = (hour * angleOneHour) + (minute * hourAngleForOneMinute);
        double minuteArrow = minute * angleOneMinute;
        return Math.abs(hourArrow - minuteArrow);
    }

}
