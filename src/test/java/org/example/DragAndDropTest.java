package org.example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void checkDragAndDropByActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //It does not work via actions()
        actions()
                .clickAndHold($("#column-a"))
                .release($("#column-b"))
                .perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void checkDragAndDropByElementMethod() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        //$("#column-a").dragAndDropTo("#column-b", DragAndDropOptions.usingJavaScript()); - The same as the command above.
        //$("#column-a").dragAndDropTo("#column-b", DragAndDropOptions.usingActions()); - Does not work as in checkDragAndDropByActions().

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}
