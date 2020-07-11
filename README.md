# UnoClone

![Image of an Uno Game](https://imgur.com/eMuDe6Y)

## Introduction

Welcome to Uno!  This project serves to recreate everyone's favorite card game as close to the rules as possible.  I originally wrote an Uno program two years ago, but it's pretty awful (we're talking all in the main method, huge chunks copy-pasted), and I always wanted to recreate it.  With some JavaFX under my belt, I decided to make the game again from the ground up (and throw in some Data Structures for good measure).

## Installation

Installation is as easy as installing and running the provided JAR file!

## Playing the Game

The game has you play against three computer players.  Relevant game information (such as whose turn it is or what card is played) is displayed at the top of the screen.

When it's your turn, simply click a card, and it will be played if it's valid.  You can cycle through cards by clicking the left and right buttons.  A card is valid if it matches the color or the value of the discard pile's top card or if it's a Wild Card (Wild or Wild Draw 4).  You can play one card each turn, and if you have no valid cards, the game will automatically play the first valid card in the deck.

The game keeps playing until a player has zero cards, and it will end.  Have fun!