import 'dart:async';

import 'package:flutter_bloc/flutter_bloc.dart';

import 'counter_state.dart';
import 'counter_event.dart';


class CounterBloc extends Bloc<CounterEvent, CounterState> {
  CounterBloc() : super(CounterValue(0)) {
    on<IncrementEvent>((event, emit) => _addToValue(1, emit));
    on<DecrementEvent>((event, emit) => _addToValue(-1, emit));
    on<SetCounterEvent>((event, emit) => emit(CounterValue(event.setTo)));
    on<Random>(_randomize);
  }

  _addToValue(int i, Emitter<CounterState> emit) {
    if (state is CounterValue) {
      emit(CounterValue((state as CounterValue).counter + i));
    }
  }

//это типо вызов внешнего апи
  FutureOr<void> _randomize(Random event, Emitter<CounterState> emit) async {
    emit(CounterLoading());
    // final int randomInt = await callApi(event.from, event.to);
    // emit(CounterValue(randomInt));
  }
}