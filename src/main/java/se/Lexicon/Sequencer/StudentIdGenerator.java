package se.Lexicon.Sequencer;

public class StudentIdGenerator {
    private static int sequencer = 1;

    private static int nextId(){

        return sequencer++;
    }

    public static int generateStudentNumber(){
        return nextId();
    }
}
