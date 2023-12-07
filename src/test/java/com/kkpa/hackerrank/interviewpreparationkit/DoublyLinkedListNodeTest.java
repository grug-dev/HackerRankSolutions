package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import com.kkpa.hackerrank.interviewpreparationkit.linkedlist.DoublyLinkedListNodeSolution;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class DoublyLinkedListNodeTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public DoublyLinkedListNodeSolution.DoublyLinkedListNode headNode;

  @Parameterized.Parameter(1)
  public int newValueToAddNode;

  @Parameterized.Parameter(2)
  public List<Integer> expectedResult;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {buildHeadNode(1, 3, 4, 10), 5, Arrays.asList(1, 3, 4, 5, 10)},
                    {buildHeadNode(2, 3, 4), 1, Arrays.asList(1, 2, 3, 4)},
                    {buildHeadNode(1, 2, 3), 4, Arrays.asList(1, 2, 3, 4)},
            }
    );
  }

  public static Object buildHeadNode(Integer... nodeValues) {
    DoublyLinkedListNodeSolution.DoublyLinkedListNode head = new DoublyLinkedListNodeSolution.DoublyLinkedListNode(0);

    Arrays.stream(nodeValues).sequential()
            .forEach(data -> {
              if (head.prev == null && head.data == 0 && head.next == null) {
                head.data = data;
                return;
              }
              DoublyLinkedListNodeSolution.DoublyLinkedListNode nextNode = head;
              while (nextNode != null) {
                if (nextNode.next == null) {
                  nextNode.next = new DoublyLinkedListNodeSolution.DoublyLinkedListNode(data);
                  nextNode.next.prev = nextNode;
                  break;
                }
                nextNode = nextNode.next;
              }

            });


    return head;
  }


  @Test
  public void myFunctionTest() {
    DoublyLinkedListNodeSolution.DoublyLinkedListNode actualResult =
            doublyLinkedListNode.sortedInsert(headNode, newValueToAddNode);
    List<Integer> result = findDataNode(actualResult);
    System.out.printf("\nFinished!. Pointing out to %s ", actualResult.data);
    Assert.assertEquals(expectedResult, result);
  }

  public List<Integer> findDataNode(DoublyLinkedListNodeSolution.DoublyLinkedListNode actualResult) {
    List<Integer> dataValues = new ArrayList<>();
    DoublyLinkedListNodeSolution.DoublyLinkedListNode tmpNode = actualResult;
    while (tmpNode != null) {
      dataValues.add(tmpNode.data);
      tmpNode = tmpNode.next;
    }

    return dataValues;
  }

}
