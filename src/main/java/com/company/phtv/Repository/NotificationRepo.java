package com.company.phtv.Repository;

import com.company.phtv.Models.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {
}
