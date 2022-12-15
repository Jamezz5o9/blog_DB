package africa.semicolon.ofofo;

import africa.semicolon.ofofo.controllers.PostController;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
//    private static Scanner keyboardInput = new Scanner(System.in);
    private static final PostController postController = new PostController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        displayMainMenu();
    }

//    private static void displayMainMenu() {
//        String mainMenu = """
//
//                press 1 for create post
//                press 2 for view post
//                press 3 to exit
//
//                """;
//
//        String userInput = input(mainMenu);
//        switch(Integer.parseInt(String.valueOf(userInput))){
//            case 1 -> createPost();
//            case 2 -> viewPost();
//            case 3 -> exitFromApp();
//        }
//    }
//
//    private static void createPost() {
//        String title = input("Enter title");
//        String body = input("Enter body");
//        CreatePostRequest createPostRequest = new CreatePostRequest();
//        createPostRequest.setTitle(title);
//        createPostRequest.setBody(body);
//        print(postController.createPost(createPostRequest));
//        displayMainMenu();
//    }
//
//    private static void viewPost() {
//        String userInput = input("Enter post id");
//        print(postController.viewPost(String.valueOf(userInput)).toString());
//        displayMainMenu();
//    }
//
//    private static void exitFromApp() {
//        print("Thank You for using our app");
//        System.exit(3);
//    }
//
//    private static String input(String prompt) {
//        return JOptionPane.showInputDialog(prompt);
////        print(prompt);
////        return keyboardInput.nextLine();
//    }
//
//
//    private static void print(String prompt){
//        JOptionPane.showMessageDialog(null, prompt);
////        System.out.println(prompt);
//}
}