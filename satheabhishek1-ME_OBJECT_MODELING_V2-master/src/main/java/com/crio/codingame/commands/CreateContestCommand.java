package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.QuestionNotFoundException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
       // sample inpur =("CREATE-CONTEST","name","LOW","creator","2"));
       
        int size = tokens.size();
         String contestName = tokens.get(1);
        Level level = Level.valueOf(tokens.get(2));
        String contestCreator = tokens.get(3);
        Integer i ; 
       
        try{
          
          
            if (size == 5) {
                i = Integer.parseInt(tokens.get(4));
                Contest contest = contestService.create(contestName, level, contestCreator, i);
                System.out.print(contest.toString());
            } else {
                Contest contest = contestService.create(contestName, level, contestCreator, null);
                System.out.print(contest.toString());
            }
    
           
            

        }catch(Exception e){
            System.out.print(e.getMessage());
        }
       

       
       


        // contestService.create(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3));


    }
    
}
