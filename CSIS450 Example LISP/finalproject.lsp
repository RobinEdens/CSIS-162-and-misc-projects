(defun quick_sort (num_list)
  (when (<= (length num_list) 1) (return-from quick_sort num_list))
  (let ((temp (car num_list)) (cdr (cdr num_list)) (lower nil) (higher nil))
	(loop for x in cdr do
	  (if (< x temp) (push x lower) (push x higher)))
	(append (quick_sort lower) (list temp) (quick_sort higher))))
	
(defun binary_search (num num_list)
	(let ((start 0)(end (1- (length num_list))))
		(do () ((< end start) nil)
			(let ((center (floor (+ start end) 2)))
			(cond ((> (nth center num_list) num)(setf end (1- center)))((< (nth center num_list) num) (setf start (1+ center)))
				(t (return t)))))))

(defun file_select (num_file)
	(setq num_list (list))
	(with-open-file (read num_file)
		(loop for line = (read-line read nil)
			while line do(setq num_list(append num_list (list (parse-integer (string line)))))))
	(return-from file_select num_list))
			
(defun write_file (sorted_list &optional (numsort "numsort.txt")) 
	(with-open-file (write numsort :direction :output)
	(format write "~s" sorted_list)))