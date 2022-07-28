public class Controller {
    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public String getResult(){
       return model.getPeriodOfLearn();
    }

    public String getNowDays(){
        return model.getNowDays();
    }
}
