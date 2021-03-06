package Framework;

public class Multiplier extends VerilogComp {

    private VerilogComp[] inputs = new VerilogComp[2];
    public Multiplier(String name, int size){
        super(name,size,false,false);
    }

    /*

   Overriden methods which write verilog code
    */
    @Override
    public String defineWire(){
        return "wire " + sizeDef() + this.getName() +"_product;\n";
    }

    @Override
    public String defineComp()
    {
        return "full_Mult #(.SIZE(" + this.getBitSize() + "))" + " " + this.getName() + "(" + this.getName() +"_product," + this.inputs[0].getName() + ", "
                + this.inputs[1].getName() + ");\n";

    }

    // adds inputs to the adder
    public void addInput(VerilogComp comp, int index)
    {
        if(Math.abs(index) > 1) System.out.println("Error index too high");
        this.inputs[index] = comp;
    }



    public String sizeDef() {
        if (this.getBitSize() > 1) {
            int size = this.getBitSize() - 1;
            return "[" + size + ":0] ";
        }

        return "";
    }

    public VerilogComp[] getInputs() {
        return inputs;
    }

}
