package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) { //Model을 통해 view에 전달할 데이터를 저장할 수 있다.
        model.addAttribute("data", "spring!!"); //key, value로 이루어진 hashmap
        return "hello"; //templates의 hello.html을 찾아간다.
    }

    @GetMapping("/hello-mvc") //hello-mvc?name=spring이라고 넘어가면 key는 name, 값은 spring
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) { //JSON 방식으로 내려준다.
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
