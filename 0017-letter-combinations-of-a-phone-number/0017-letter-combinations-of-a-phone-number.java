class Solution {

    private HashMap<Character,String> map;
    private List<String> ans;
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return new ArrayList<>();
        ans = new ArrayList<>();
        //it is evident that we can use backtracking here, since constraint number is less
        //first, we need to assign numbers to the strings as in question
        map = new HashMap<>(); this.digits = digits;
        map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");map.put('5',"jkl");
        map.put('6',"mno");map.put('7',"pqrs");map.put('8',"tuv");map.put('9',"wxyz");
        backtracking(new StringBuilder(),0);
        return ans;
    }
    
    private void backtracking(StringBuilder curr,int index){
       //base case
       if(curr.length() == digits.length()){
           ans.add(curr.toString()); return;
       }

       //to start the loop, we need to get into initial first level
       String options = map.get(digits.charAt(index));
       //now start the loop
       for(char i : options.toCharArray()){
          curr.append(i); //add
          backtracking(curr,index+1); //recurse and use
          curr.deleteCharAt(curr.length()-1); //remove
       }
    }
}