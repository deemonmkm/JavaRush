package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {

    private Controller controller;
    //private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    private final String filePath = "D:\\Downloads\\JavaRushHomeWork\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task28\\task2810\\view" + "\\vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("junior");
    }

    private String getUpdatedFileContent(List<Vacancy> list) {
        try {
            Document document = getDocument();
            Element template = document.getElementsByClass("template").first();
            Element copyTemplate = template.clone();
            copyTemplate.removeClass("template").removeAttr("style");

            Elements elements = document.getElementsByClass("vacancy");
            for (Element element : elements) {
                if(!element.hasClass("template")) element.remove();
            }

            for (Vacancy vacancy : list) {
                Element vacancyElement = copyTemplate.clone();
                vacancyElement.getElementsByClass("city").append(vacancy.getCity());
                vacancyElement.getElementsByClass("companyName").append(vacancy.getCompanyName());
                vacancyElement.getElementsByClass("salary").append(vacancy.getSalary());
                vacancyElement.getElementsByTag("a").append(vacancy.getTitle()).attr("href", vacancy.getUrl());
                template.before(vacancyElement.outerHtml());
            }
            return document.html();

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
