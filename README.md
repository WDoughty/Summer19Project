# Summer19Project

outlines for algos

### Generating puzzles 

  generate n numbers (n>=17) place in random place on board
  
  Recursive backtracking  
  Start:  
  find next empty cell   
  if # is safe  
    put # in cell  
    goto Start  
  else  
    go back   
    
    
  
  ### Solvable puzzles
  
  A solvable sudoku has exactly 1 solution   
  Start:  
  Remove # board randomly  
  count # of solutions  
    if solutions == 1  
      go to Start  
    else   
      go back   
      (This could remove another random # OR return current board as solvable.   
      Option could be easy as n numbers left where 17<=n<81)
    
  
  
