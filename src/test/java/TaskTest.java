import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(123, "Позвонить родителям");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(123, "Позвонить родителям");

        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTaskMatches() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskMatches2() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("Выкатка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskNotMatches() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("вторник");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicTaskMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicTaskNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Колбаса");

        Assertions.assertFalse(actual);
    }

    @Test
   public void shouldTitle() {
        String expectedTitle = "Задача";
        SimpleTask task = new SimpleTask(234, "Задача");

        Assertions.assertEquals("Задача", task.getTitle());
    }

    @Test
    public void shouldSetId() {
        Task id = new Task(23);
        Assertions.assertEquals(23, id.getId());
    }


}