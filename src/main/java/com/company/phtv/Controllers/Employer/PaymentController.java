package com.company.phtv.Controllers.Employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Enums.PayPal;
import com.company.phtv.Enums.PaypalPaymentMethod;
import com.company.phtv.Models.DTO.SubcriptionPlanDTO;
import com.company.phtv.Services.PayPalService;
import com.company.phtv.Services.SubcriptionPlanService;
import com.company.phtv.Utils.HttpException;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;

@RestController
@RequestMapping("/employer/paypal")
public class PaymentController {

    BaseController<String> _baseController = new BaseController<String>();
    BaseController<List<SubcriptionPlanDTO>> _baseControllers = new BaseController<List<SubcriptionPlanDTO>>();
    @Autowired
    private PayPalService paypalService;
    @Autowired
    SubcriptionPlanService subcriptionPlanService;
    private static int id_sub;

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestParam("id") int id, @RequestParam("price") Double price) {
        try {
            id_sub = id;
            String description = subcriptionPlanService.getById(id).getName();
            Payment payment = paypalService.createPayment(
                    price,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PayPal.sale,
                    description,
                    "http://localhost:3000/employer/emprofile",
                    "http://localhost:3000/employer/emprofile");
            for (Links links : payment.getLinks())
                if (links.getRel().equals("approval_url"))
                    return _baseController.success(links.getHref());
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            subcriptionPlanService.createForEmployer(id_sub);
            if (payment.getState().equals("approved"))
                return _baseController.success("Success");
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
        return null;
    }
}
