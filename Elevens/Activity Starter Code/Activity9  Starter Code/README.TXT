1. Board size is an instance variable, but the size function doesn't exist in the board class, instead it only deals with Decks, which are always the same for all types of games, so there's no reason to make it abstract

2. Similar to question 1, it's because the actual cards are a different object, the deck object, which is univeral for all types of games.

3. Yes, it would still work polymorphically. The new design would also work but it might be a bit more technical telling the difference between the types of games.

