abstract class CounterEvent {}

class IncrementEvent extends CounterEvent{}
class DecrementEvent extends CounterEvent{}
class SetCounterEvent extends CounterEvent{
  final int setTo;

  SetCounterEvent({required this.setTo});
}

class Random extends CounterEvent{
  final int from;
  final int to;

  Random({required this.from, required this.to});
}
