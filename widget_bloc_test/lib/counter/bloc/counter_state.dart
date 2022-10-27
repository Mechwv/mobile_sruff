abstract class CounterState{}

class CounterValue extends CounterState {
  final int counter;

  CounterValue(this.counter);
}

class CounterLoading extends CounterState {}