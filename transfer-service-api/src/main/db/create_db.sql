DROP DATABASE `utilization-app`;

CREATE DATABASE `utilization-app`;

USE `utilization-app`;

CREATE TABLE `document` (
  `id` VARCHAR(36) NOT NULL,
  `version` INT(11) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `name` VARCHAR(36) NOT NULL,
  `no_of_sheet` INT(11) NOT NULL,
  `uploaded_by` VARCHAR(60) DEFAULT NULL,
  `status` INT(11) DEFAULT '0',
  `error` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `resource_detail` (
  `id` VARCHAR(36) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `doc_id` VARCHAR(36) NOT NULL,
  `sheet_number` INT(11) NOT NULL,
  `date` DATE DEFAULT NULL,
  `customer_name` VARCHAR(256) DEFAULT NULL,
  `project_name` VARCHAR(256) DEFAULT NULL,
  `project_serviceline` VARCHAR(256) DEFAULT NULL,
  `project_department` VARCHAR(256) DEFAULT NULL,
  `acenumber` VARCHAR(32) DEFAULT NULL,
  `name` VARCHAR(256) DEFAULT NULL,
  `user_name` VARCHAR(256) DEFAULT NULL,
  `employee_designation` VARCHAR(256) DEFAULT NULL,
  `employee_serviceline` VARCHAR(256) DEFAULT NULL,
  `employee_department` VARCHAR(256) DEFAULT NULL,
  `employee_location` VARCHAR(256) DEFAULT NULL,
  `employee_track` VARCHAR(256) DEFAULT NULL,
  `employee_workRole` VARCHAR(256) DEFAULT NULL,
  `acquired_company` VARCHAR(256) DEFAULT NULL,
  `source_company` VARCHAR(256) DEFAULT NULL,
  `dor` VARCHAR(256) DEFAULT NULL,
  `time_spent` FLOAT(11,2) DEFAULT 0.00,
  `billed_hours` FLOAT(11,2) DEFAULT 0.00,
  `allocation` FLOAT(11,2) DEFAULT 0.00,
  `comments` VARCHAR(256) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8

/* Clear all data*/
TRUNCATE document;
TRUNCATE resource_detail
