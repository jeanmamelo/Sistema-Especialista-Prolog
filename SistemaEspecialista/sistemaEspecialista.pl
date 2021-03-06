﻿% febre(X), onde X = dias que esta com febre

febre(1).
febre(2).
febre(3).
febre(4).
febre(5).
febre(6).
febre(7).


% febre(X), onde X = tipo da febre

febre(terca).
 %terca
febre(quarta).
 %quarta

% subfebril(X), onde X = dias que encontra-se subfebril
subFebril(1).
subFebril(2).


% dorArticulacao(X), onde X = intensidade da dor na articulacao

dorArticulacao(leve).
dorArticulacao(moderada).
dorArticulacao(intensa).


inchacoArticulacao(leve).
inchacoArticulacao(intenso).


coceira(leve).
coceira(moderada).
coceira(intensa).


hipertrofia(leve).
hipertrofia(moderada).
hipertrofia(intensa).


dorCabeca(intensa).

%sintoma padrao para facilitar o codgo
sintoma(padrao).                                 

% classificao dos sintomas

sintoma(febre(1)).
sintoma(febre(2)).
sintoma(febre(3)).
sintoma(febre(4)).
sintoma(febre(5)).
sintoma(febre(6)).
sintoma(febre(7)).


sintoma(subFebril(1)).
sintoma(subFebril(2)).


sintoma(dorArticulacao(leve)).
sintoma(dorArticulacao(moderada)).
sintoma(dorArticulacao(intensa)).


sintoma(inchacoArticulacao(leve)).
sintoma(inchacoArticulacao(intensa)).


sintoma(coceira(leve)).
sintoma(coceira(moderada)).
sintoma(coceira(intensa)).


sintoma(hipertrofia(leve)).
sintoma(hipertrofia(moderada)).
sintoma(hipertrofia(intensa)).

sintoma(dorCabeca(moderada)).
sintoma(dorCabeca(intensa)).

sintoma(faltaApetite).

sintoma(sudorese).

sintoma(tremor).

sintoma(fadigaFraqueza).

sintoma(nauseaVomito).

sintoma(dorCorpo).

sintoma(calafrios).

sintoma(febre).

sintoma(manchaPele).

sintoma(dorMuscular).

sintoma(conjutivite).


% associa��o dos sintomas com as doen�as

doenca(dengue, padrao).

doenca(dengue, febre(X)) :- 
 
   sintoma(febre(X)),

    X =< 7.

doenca(dengue, manchaPele).

doenca(dengue, dorMuscular).

doenca(dengue, dorArticulacao(leve)).

doenca(dengue, dorCabeca(intensa)).

doenca(dengue, coceira(leve)).

doenca(dengue, hipertrofia(leve)).


doenca(zika, subFebril(X)) :-
 
   sintoma(subFebril(X)),

    X =< 2.

doenca(zika, padrao).

doenca(zika, manchaPele).

doenca(zika, dorMuscular).

doenca(zika, dorArticulacao(leve)).

doenca(zika, dorArticulacao(moderada)).

doenca(zika, inchacoArticulacao(leve)).

doenca(zika, conjutivite).

doenca(zika, dorCabeca(moderada)).

doenca(zika, coceira(moderada)).

doenca(zika, coceira(intensa)).

doenca(zika, hipertrofia(intenso)).



doenca(chikungunya, febre(X)) :-

    sintoma(febre(X)),

    X =< 3.
doenca(chikungunya, padrao).

doenca(chikungunya, manchaPele).


doenca(chikungunya, dorArticulacao(moderada)).

doenca(chikungunya, dorArticulacao(intensa)).

doenca(chikungunya, inchacoArticulacao(intensa)).

doenca(chikungunya, conjutivite).

doenca(chikungunya, coceira(leve)).

doenca(chikungunya, hipertrofia(moderada)).

doenca(chikungunya, dorCabeca(moderada)).


doenca(febreAmarela, padrao).

doenca(febreAmarela, febre).

doenca(febreAmarela, dorCabeca(intensa)).

doenca(febreAmarela, fadigaFraqueza).

doenca(febreAmarela, nauseaVomito).

doenca(febreAmarela, dorCorpo).

doenca(febreAmarela, calafrios).


doenca(malaria, padrao).

doenca(malaria, febre).

doenca(malaria, calafrios).

doenca(malaria, faltaApetite).

doenca(malaria, sudorese).

doenca(malaria, tremor).

doenca(malaria, fadigaFraqueza).

doenca(malaria, nauseaVomito).




encontraDoenca(ListaSintomas, Lista) :- 
   findall(Doenca, buscapadrao(ListaSintomas, Doenca), Lista).



splitVetor(HeadListaSintomas, TailListaSintomas, ListaSintomas) :-
   
    [HeadListaSintomas|TailListaSintomas] = ListaSintomas.



retornaDoenca([],_).



retornaDoenca(ListaSintomas, Doenca) :-
 
    splitVetor(HeadListaSintomas,TailListaSintomas,ListaSintomas),

    doenca(Doenca, HeadListaSintomas),

    retornaDoenca(TailListaSintomas, Doenca).


buscapadrao(ListaSintomas, Doenca):-

    splitVetor(HeadListaSintomas,_,ListaSintomas),

    doenca(Doenca, HeadListaSintomas).



%ListaSintomas = [dorArticulacao(leve) | []],

%encontraDoenca(ListaSintomas, Lista).	