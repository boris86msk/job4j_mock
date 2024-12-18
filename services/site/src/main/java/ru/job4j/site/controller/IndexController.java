package ru.job4j.site.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.site.dto.CategoryDTO;
import ru.job4j.site.service.AuthService;
import ru.job4j.site.service.CategoriesService;
import ru.job4j.site.service.InterviewsService;
import ru.job4j.site.service.NotificationService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static ru.job4j.site.controller.RequestResponseTools.getToken;

@Controller
@AllArgsConstructor
@Slf4j
public class IndexController {
    private final CategoriesService categoriesService;
    private final InterviewsService interviewsService;
    private final AuthService authService;
    private final NotificationService notifications;

    @GetMapping({"/", "index"})
    public String getIndexPage(Model model, HttpServletRequest req) throws JsonProcessingException {
        RequestResponseTools.addAttrBreadcrumbs(model,
                "Главная", "/"
        );
        try {
            var mostPopular = categoriesService.getMostPopular();
            var listId = mostPopular.stream()
                    .map(CategoryDTO::getId)
                    .toList();
            var interviewsByCategory = new HashMap<>();
            for (Integer id : listId) {
                interviewsByCategory.put(id, interviewsService.getByTopicId(id, 0, 0));
            }

            model.addAttribute("interviews", interviewsByCategory);
            model.addAttribute("categories", mostPopular);
            var token = getToken(req);
            if (token != null) {
                var userInfo = authService.userInfo(token);
                model.addAttribute("userInfo", userInfo);
                model.addAttribute("userDTO", notifications.findCategoriesByUserId(userInfo.getId()));
                RequestResponseTools.addAttrCanManage(model, userInfo);
            }
        } catch (Exception e) {
            log.error("Remote application not responding. Error: {}. {}, ", e.getCause(), e.getMessage());
        }
        model.addAttribute("new_interviews", interviewsService.getByType(1));
        return "index";
    }
}