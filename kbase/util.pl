
write_list([]).
write_list([X|L]):-
    writeln(X),
    write_list(L).



assert_once(NewFact):-

    functor(NewFact, Name, Arity),
    findall(_, between(1,Arity,_Ignore), List),
    OldFact =..[Name|List],
    dynamic(Name/Arity),
    assert_once_2(OldFact, NewFact).


assert_once_2(OldFact, NewFact):-
    OldFact,
    retractall(OldFact),
    assert(NewFact),
    !.


assert_once_2(_, NewFact):-
    assert(NewFact).


retract_safe(Fact):-
    functor(Fact, Name, Arity),
    dynamic(Name/Arity),
    \+ Fact,
    !.

retract_safe(Fact):-
    functor(Fact, Name, Arity),
    dynamic(Name/Arity),
    retract(Fact),
    !.


is_bit_event(OldBit, NewBit, 0):-
    OldBit\==0,
    NewBit ==0,
    !.

is_bit_event(OldBit, NewBit, 1):-
    OldBit ==0,
    NewBit\==0.

is_event(OldValue, NewValue, BASE_STATE):-
    OldValue ==BASE_STATE,
    NewValue\==BASE_STATE.










