# AMD Summit 2019 - Functional DDD with Jan Stępień

## Creating a "functional" To Do List

The task was to build a ToDo list by using the functional principle of immutability. The following four use cases were required.
1. An empty ToDo list can be created.
2. It is possible to add a task to the list. This task will have the state "open".
3. It is possible to change the state of a task in the list to an arbitrary string.
4. Any action on the list can be made undone.

## Testing with generators

We usually only test certain examples. But it is quite difficult for any developer to cover all edge cases. Generators allow testing of properties, not examples, by generating "all possible cases". For Java this can be done using "QuickTheories". These frameworks usually also offer a feature called **shrinking**: If they find a failing case, they try to reduce the input data until they find a minimal example. How they do this is up to the framework. For a simple (and not minimal) example see `ToDoListWithGeneratorsTest`.
