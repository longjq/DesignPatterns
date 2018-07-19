namespace DesignPatterns\Structural\Decorator;

class Webservice implements RenderInterface{

    protected $data;

    public function __construct($data){
        $this->data = $data;
    }

    public function renderData(){
        return $this->data;
    }
}